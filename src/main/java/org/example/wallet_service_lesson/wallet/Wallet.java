package org.example.wallet_service_lesson.wallet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "wallets", indexes = {
        @Index(name = "idx_wallet_id", columnList = "wallet_id")
})
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, name = "wallet_id")
    private UUID walletId;

    @Column(nullable = false, precision = 10, scale = 2, name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(nullable = false, name = "version")
    @Version
    private long version;

    @Column(nullable = false, name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Wallet(UUID walletId) {
        this.walletId = walletId;
        this.balance = BigDecimal.ZERO;
    }
}





