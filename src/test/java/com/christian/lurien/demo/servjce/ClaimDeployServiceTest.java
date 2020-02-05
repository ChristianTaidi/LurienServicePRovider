package com.christian.lurien.demo.servjce;

import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.service.ClaimDeployService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimDeployServiceTest {

    @Autowired
    ClaimDeployService deployService;

    @Before
    public void init(){

    }

    @Test
    public void it_should_return_a_contract_address(){
        String contractAddress = null;
        try {
            contractAddress = deployService.deployClaim(mockClaim());
            System.out.println(contractAddress);
        } catch (Exception e) {
            System.out.println("Error deploying");
            e.printStackTrace();
        }finally {
            Assertions.assertThat(contractAddress).isNotNull();
        }
    }

    private Claim mockClaim(){
        Claim claim = new Claim("TEST_CLAIM","DEFAULT JSON");
        claim.setId(1L);
        return claim;
    }

}
