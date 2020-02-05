package com.christian.lurien.demo.pojos;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="user_claims")
public class Claim {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String claimType;

    @Column
    private String contractAddress;

    @Column
    private String claimJson;

    public Claim(){
        //Empty constructor for JPA
    }

    public Claim(String claimType,String claimJSon){
        this.claimType = claimType;
        this.claimJson=claimJSon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimJson() {
        return claimJson;
    }

    public void setClaimJson(String claimJson) {
        this.claimJson = claimJson;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return id.equals(claim.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
