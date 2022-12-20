package org.nwolfhub.messengermessages.crypto.model;

import javax.persistence.*;

@Entity
@Table(name = "keys", schema = "crypto")
public class KeyPair {
    @Id
    @SequenceGenerator(name = "uidGen", sequenceName = "users.id_increaser", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "key_ids")
    public Integer id;
}
