package org.example.wallet_service_lesson.wallet;

import lombok.RequiredArgsConstructor;
import org.example.wallet_service_lesson.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepo walletRepo;

    public Wallet create(Wallet wallet){
        if (walletRepo.findWalletByWalletId(wallet.getWalletId()).isPresent()) {
            throw new NotFoundException("Кошелек с id: '%s' уже существует".formatted(wallet.getWalletId()));
        }
       return walletRepo.save(wallet);
    }

    public List<Wallet> findAll(){
        return walletRepo.findAll();
    }

    public Wallet findById(UUID id) {
       return walletRepo.findById(id).orElseThrow(() -> new NotFoundException("Кошелек с id: '%s' не найден".formatted(id)));
    }

    public void delete(UUID id) {
       Wallet wallet = walletRepo.findById(id).orElseThrow(() -> new NotFoundException("Кошелек с id: '%s' не найден".formatted(id)));
       walletRepo.delete(wallet);
    }

//    public Wallet update(Wallet wallet, UUID id){
//        Wallet newWalletBalance = walletRepo.findById(id).orElseThrow(() -> new NotFoundException("Кошелек с id: '%s' не найден".formatted(id)));
//        newWalletBalance.setBalance(wallet.getBalance());
//
//        walletRepo.save(newWalletBalance);
//
//        return newWalletBalance;
//    }
}
