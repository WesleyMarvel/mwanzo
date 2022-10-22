package com.example.mwanzo.api;
import com.example.mwanzo.domain.NftRecord;
import com.example.mwanzo.service.nftrecord.NftRecordDto;
import com.example.mwanzo.service.nftrecord.NftRecordRequest;
import com.example.mwanzo.service.nftrecord.NftRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/token-record")
public class TokenRecordController {
    private final NftRecordService nftRecordService;
    public TokenRecordController(NftRecordService nftRecordService) {
        this.nftRecordService = nftRecordService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<NftRecord> getAll(){
        return nftRecordService.getAll();
    }

    @GetMapping("/get-by-token-id/{tokenId}")
    @ResponseStatus(HttpStatus.OK)
    public NftRecordDto getById(@PathVariable Long tokenId){
       return nftRecordService.getById(tokenId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public NftRecordDto create(@RequestBody NftRecordRequest nftRecordRequest){
        return nftRecordService.create(nftRecordRequest);
    }

    @PutMapping("/update/{tokenId}")
    @ResponseStatus(HttpStatus.OK)
    public NftRecordDto update(@PathVariable Long tokenId, @RequestBody NftRecordRequest nftRecordRequest){
        return nftRecordService.update(tokenId, nftRecordRequest);
    }

    @GetMapping("/tokenAddress")
    @ResponseStatus(HttpStatus.OK)
    public NftRecordDto getByTokenAddress(String tokenAddress){
        return nftRecordService.getByTokenAddress(tokenAddress);
    }

    @DeleteMapping("/delete/{tokenId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long tokenId){
        nftRecordService.delete(tokenId);
    }

}
