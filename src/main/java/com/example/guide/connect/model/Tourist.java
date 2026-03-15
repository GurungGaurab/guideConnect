package com.example.guide.connect.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tourists")
public class Tourist extends User {
}
