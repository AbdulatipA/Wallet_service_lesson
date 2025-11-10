package org.example.wallet_service_lesson.wallet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping()
    public ResponseEntity<Wallet> create(@RequestBody Wallet wallet) {
        return ResponseEntity.ok(walletService.create(wallet));
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> getAll() {
       return ResponseEntity.ok(walletService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wallet> getByID(@PathVariable UUID id) {
        return ResponseEntity.ok(walletService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        walletService.delete(id);
        return ResponseEntity.ok("Кошелек удален");
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Wallet> update(@RequestBody Wallet wallet, @PathVariable UUID id) {
//        return ResponseEntity.ok(walletService.update(wallet, id));
//    }
}
