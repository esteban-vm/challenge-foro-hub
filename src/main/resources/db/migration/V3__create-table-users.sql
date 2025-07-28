CREATE TABLE IF NOT EXISTS users (

    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    profile_id BIGINT NOT NULL,

    CONSTRAINT fk_users_profiles FOREIGN KEY (profile_id) REFERENCES profiles (id)

);
