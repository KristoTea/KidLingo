
CREATE TABLE IF NOT EXISTS dictionary (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    english VARCHAR(30) NOT NULL,
    french VARCHAR(30) NOT NULL,
    italian VARCHAR(30) NOT NULL,
    german VARCHAR(30) NOT NULL,
    category VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS generated_picture (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    word VARCHAR(30),
    type VARCHAR(30),
    image_data VARCHAR(200)
);