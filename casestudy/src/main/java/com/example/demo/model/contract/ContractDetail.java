package com.example.demo.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @EmbeddedId
    private ContractDetailKey id;

    @ManyToOne
    @MapsId("contract_id")
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @MapsId("attach_service_id")
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetailKey getId() {
        return id;
    }

    public void setId(ContractDetailKey id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ContractDetail{" +
                "id=" + id +
                ", contract=" + contract +
                ", attachService=" + attachService +
                ", quantity=" + quantity +
                '}';
    }
}
