package org.example.wallet_service_lesson.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, UUID> {
    Optional<Wallet> findWalletByWalletId(UUID id);
}
