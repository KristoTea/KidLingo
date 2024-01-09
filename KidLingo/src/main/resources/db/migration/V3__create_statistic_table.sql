CREATE TABLE IF NOT EXISTS statistic (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    device_id VARCHAR(30) NOT NULL,
    language VARCHAR(30) NOT NULL,
    level VARCHAR(30) NOT NULL,
    category VARCHAR(30) NOT NULL,
    number_of_correct_answers INT NOT NULL,
    solving_speed DECIMAL(18,9) NOT NULL,
    play_timestamp TIMESTAMP NOT NULL
);