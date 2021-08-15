package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;


    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;


    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return model + " " + series;
    }

}

