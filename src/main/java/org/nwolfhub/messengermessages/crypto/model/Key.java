package org.nwolfhub.messengermessages.crypto.model;

import javax.persistence.*;
import java.security.PublicKey;

@Entity
@Table(name = "keys", schema = "crypto")
public class Key {
    @Id
    @SequenceGenerator(name = "key_ids", sequenceName = "crypto.id_increaser", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "key_ids")
    @Column(name = "id", unique = true)
    public Integer id;
    @Column(name = "userOwner", unique = true)
    public Integer userOwner;
    public PublicKey key;

    public Key() {

    }

    public Key(Integer id, Integer userOwner, PublicKey key) {
        this.id = id;
        this.userOwner = userOwner;
        this.key = key;
    }

    public Integer getId() {
        return id;
    }

    public Key setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserOwner() {
        return userOwner;
    }

    public Key setUserOwner(Integer userOwner) {
        this.userOwner = userOwner;
        return this;
    }

    public PublicKey getKey() {
        return key;
    }

    public Key setKey(PublicKey key) {
        this.key = key;
        return this;
    }
}
