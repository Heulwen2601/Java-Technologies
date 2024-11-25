package vn.edu.tdtu.lab910.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.lab910.model.UserAccount;
import vn.edu.tdtu.lab910.repository.UserAccountRepository;
import vn.edu.tdtu.lab910.util.JwtUtil;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    // POST: Register a new account
    @PostMapping("/register")
    public void createUserAccount(@RequestBody UserAccount userAccount) {
        String hashedPassword = bCryptPasswordEncoder.encode(userAccount.getPassword());
        userAccount.setPassword(hashedPassword);
        userAccountRepository.save(userAccount);
    }

    // POST: User login
    @PostMapping("/login")
    public String loginUserAccount(@RequestBody UserAccount userAccount) {
        UserAccount user = userAccountRepository.findUserAccountByEmail(userAccount.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        // Kiểm tra mật khẩu
        if (bCryptPasswordEncoder.matches(userAccount.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(userAccount);
            return token;
        } else {
            throw new RuntimeException("Incorrect password");
        }
    }
}