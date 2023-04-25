package com.example.demo.model.contract;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContractDetailKey implements Serializable {
    @Column(name = "contract_id")
    Integer contractId;

    @Column(name = "attach_service_id")
    Integer attachServiceId;

    public ContractDetailKey() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDetailKey that = (ContractDetailKey) o;
        return Objects.equals(contractId, that.contractId) &&
                Objects.equals(attachServiceId, that.attachServiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, attachServiceId);
    }
}
