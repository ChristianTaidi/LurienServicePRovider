package com.christian.lurien.demo.servjce;

import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.repository.ClaimRepository;
import com.christian.lurien.demo.service.impl.ClaimGenServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ClaimGenServiceTest {

    @InjectMocks
    private ClaimGenServiceImpl genService;

    @Mock
    private ClaimRepository mockRepository;

    @Before
    public void init(){
        when(mockRepository.findAll()).thenReturn(Arrays.asList(mockClaim()));
        when(mockRepository.save(any(Claim.class))).thenReturn(mockClaim());
    }

    @Test
    public void when_generate_claim_it_should_generate_and_save_a_new_claim(){
        Claim genClaim = genService.generateClaim();
        Assertions.assertThat(mockRepository.findAll()).contains(genClaim);
    }


    private Claim mockClaim(){
        Claim claim = new Claim("TEST_CLAIM","DEFAULT JSON");
        claim.setId(1L);
        return claim;
    }
}
