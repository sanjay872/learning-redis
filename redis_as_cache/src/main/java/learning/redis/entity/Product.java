package learning.redis.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

//@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
//@RedisHash("Product") // it enables to use spring data repository to interact with redis and also to mark it as product entity
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    private int qty;
    private long price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
