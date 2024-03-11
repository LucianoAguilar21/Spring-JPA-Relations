package com.lucianoaguilar.springjpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    // Uno a uno
    @OneToOne
    private User user;

    // Uno a muchos
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Address> addresses = new HashSet<Address>();

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "client_products",
            joinColumns = {
                    @JoinColumn(name = "fk_client")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_product")
            }
    )
    private Set<Product> products = new HashSet<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(user, client.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user);
    }
}
