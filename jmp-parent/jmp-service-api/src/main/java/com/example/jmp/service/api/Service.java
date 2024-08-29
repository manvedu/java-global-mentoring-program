package com.example.jmp.service.api;

import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.BankCardType;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;

import java.util.List;
import java.util.Optional;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Service {
    int MIN_PAYABLE_AGE = 18;

    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

    List<User> getAllUsers();
    List<Subscription> getAllSubscriptions();

    default double getAverageUsersAge() {
        List<User> users = getAllUsers();
        return users.stream()
                .map(User::getBirthday)
                .mapToLong(birthday -> ChronoUnit.DAYS.between(birthday, LocalDate.now()))
                .average().getAsDouble();
    }

    static boolean isPayableUser(User user){
        LocalDate today = LocalDate.now();
        long age = ChronoUnit.YEARS.between(user.getBirthday(), today);
        return age >= MIN_PAYABLE_AGE;
    }

    default List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return getAllSubscriptions().stream()
                .filter(condition)
                .collect(Collectors.toUnmodifiableList());
    }
    BankCard createBankCard(User user, BankCardType type);
}