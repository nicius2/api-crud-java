CREATE TABLE car (
    id UUID PRIMARY KEY,
    name_car VARCHAR(255) NOT NULL,
    plate VARCHAR(255) NOT NULL UNIQUE,
    available BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE rentals (
    id UUID PRIMARY KEY,
    car_id UUID NOT NULL,
    rented_at TIMESTAMP NOT NULL,
    returned_at TIMESTAMP,
    CONSTRAINT fk_rental_car,
        FOREIGN KEY (car_id)
        references (car id)
);