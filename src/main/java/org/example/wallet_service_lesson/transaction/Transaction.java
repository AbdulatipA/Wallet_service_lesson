package org.example.wallet_service_lesson.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.wallet_service_lesson.OperationType;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions", indexes = {
        @Index(name = "idx_transaction_wallet_id", columnList = "wallet_id"),
        @Index(name = "idx_transaction_createAt", columnList = "create_at")
})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name = "wallet_id")
    private UUID walletId;

    @Column(nullable = false, name = "operation_type")
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @Column(nullable = false, precision = 10, scale = 2, name = "amount")
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(nullable = false, precision = 10, scale = 2, name = "balance_before")
    private BigDecimal balanceBefore = BigDecimal.ZERO;

    @Column(nullable = false, precision = 10, scale = 2, name = "balance_after")
    private BigDecimal balanceAfter = BigDecimal.ZERO;

    @Column(nullable = false, name = "create_at")
    @CreationTimestamp
    private LocalDateTime createAt;
}
