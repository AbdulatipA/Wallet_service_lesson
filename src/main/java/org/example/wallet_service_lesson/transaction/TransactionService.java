package org.example.wallet_service_lesson.transaction;

import lombok.RequiredArgsConstructor;
import org.example.wallet_service_lesson.OperationType;
import org.example.wallet_service_lesson.exceptions.InsufficientFundsException;
import org.example.wallet_service_lesson.exceptions.NotFoundException;
import org.example.wallet_service_lesson.wallet.Wallet;
import org.example.wallet_service_lesson.wallet.WalletRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepo transactionRepo;
    private final WalletRepo walletRepo;


    @Transactional
    public void create(Transaction transaction) {
        Wallet wallet = walletRepo.findWalletByWalletId(transaction.getWalletId()).orElseThrow(
                () -> new NotFoundException("Кошелек с id: '%s' не существует".formatted(transaction.getWalletId()))
        );

        if (transaction.getOperationType().equals(OperationType.DEPOSIT)) {
            deposit(transaction, wallet);
        }

        if (transaction.getOperationType().equals(OperationType.WITHDRAW)) {
            withdraw(transaction, wallet);
        }

        wallet.setBalance(transaction.getBalanceAfter());
        transactionRepo.save(transaction);
    }


    private void deposit(Transaction transaction, Wallet wallet) {
        transaction.setBalanceAfter(wallet.getBalance().add(transaction.getAmount()));
        transaction.setBalanceBefore(wallet.getBalance());
    }

    private void withdraw(Transaction transaction, Wallet wallet) {
        if (transaction.getAmount().compareTo(wallet.getBalance()) > 0) {
            throw new InsufficientFundsException("недостаточно средств");
        }
        transaction.setBalanceAfter(wallet.getBalance().subtract(transaction.getAmount()));
        transaction.setBalanceBefore(wallet.getBalance());
    }
}
