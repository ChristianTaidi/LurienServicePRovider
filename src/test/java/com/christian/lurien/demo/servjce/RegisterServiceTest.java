package com.christian.lurien.demo.servjce;

import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.repository.ClaimRepository;
import com.christian.lurien.demo.service.RegisterService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterServiceTest {

    @Autowired
    private RegisterService registerService;

    @MockBean
    private ClaimRepository repository;

    @Test
    public void test_regServiceInits(){
        Assertions.assertThat(registerService).isNotNull();
    }

    @Test
    public void test_repositoryInits(){
        Assertions.assertThat(repository).isNotNull();
    }



    private Claim mockClaim(){
        return new Claim("TEST_CLAIM","DEFAULT JSON");
    }
}
