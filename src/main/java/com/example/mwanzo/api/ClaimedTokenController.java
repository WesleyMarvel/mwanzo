package com.example.mwanzo.api;

import com.example.mwanzo.domain.ClaimedToken;
import com.example.mwanzo.service.claimedtoken.ClaimedTokenDto;
import com.example.mwanzo.service.claimedtoken.ClaimedTokenRequest;
import com.example.mwanzo.service.claimedtoken.ClaimedTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/claimed-token")
public class ClaimedTokenController {
    private final ClaimedTokenService claimedTokenService;

    public ClaimedTokenController(ClaimedTokenService claimedTokenService) {
        this.claimedTokenService = claimedTokenService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ClaimedToken> getAll(){
        return claimedTokenService.getAll();
    }

    @GetMapping("/get-by-token-id/{tokenId}")
    @ResponseStatus(HttpStatus.OK)
    public ClaimedTokenDto getByTokenId(@PathVariable Long tokenId){
        return claimedTokenService.getByTokenId(tokenId);
    }

    @GetMapping("/get-by-owner/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ClaimedTokenDto getByOwner(@PathVariable Long customerId){
        return claimedTokenService.getByOwner(customerId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ClaimedTokenDto create(@RequestBody ClaimedTokenRequest claimedTokenRequest){
        return claimedTokenService.create(claimedTokenRequest);
    }

    @PutMapping("/update/{tokenId}")
    @ResponseStatus(HttpStatus.OK)
    public ClaimedTokenDto update(@PathVariable Long tokenId, @RequestBody ClaimedTokenRequest claimedTokenRequest){
        return claimedTokenService.update(tokenId, claimedTokenRequest);
    }

    @DeleteMapping("/delete/{tokenId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long tokenId){
        claimedTokenService.delete(tokenId);
    }

}
