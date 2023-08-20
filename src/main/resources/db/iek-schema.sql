CREATE TABLE IEK_LOCATOR
(
    id         INTEGER PRIMARY KEY,
    bizz       VARCHAR(36)  NOT NULL,
    title      VARCHAR(20)  NOT NULL,
    website    VARCHAR(100) NOT NULL,
    account    VARCHAR(100) NOT NULL,
    hex_secret VARCHAR(150) NOT NULL,
    remark     VARCHAR(255),
    is_active  CHAR(1)      NOT NULL CHECK (is_active IN ('Y', 'N')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IEK_GENERATOR
(
    id         INTEGER PRIMARY KEY,
    bizz       VARCHAR(36) NOT NULL,
    topic      VARCHAR(20) NOT NULL,
    attribute  VARCHAR(20) NOT NULL,
    source     LONGTEXT,
    expect     LONGTEXT,
    remark     VARCHAR(255),
    is_active  CHAR(1)     NOT NULL CHECK (is_active IN ('Y', 'N')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IEK_CONVERTER
(
    id         INTEGER PRIMARY KEY,
    bizz       VARCHAR(36) NOT NULL,
    topic      VARCHAR(20) NOT NULL,
    attribute  VARCHAR(20) NOT NULL,
    source     LONGTEXT,
    expect     LONGTEXT,
    remark     VARCHAR(255),
    is_active  CHAR(1)     NOT NULL CHECK (is_active IN ('Y', 'N')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
