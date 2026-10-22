CREATE TABLE support_tickets (
    ticket_id VARCHAR(20) PRIMARY KEY,
    title TEXT,
    description TEXT,
    status VARCHAR(30),
    priority VARCHAR(20),
    category VARCHAR(50),
    environment VARCHAR(30),
    assigned_team VARCHAR(50),
    tenant_id VARCHAR(30),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE ticket_comments (
    comment_id SERIAL PRIMARY KEY,
    ticket_id VARCHAR(20),
    author_name VARCHAR(100),
    comment_text TEXT,
    created_at TIMESTAMP
);

CREATE TABLE incident_reports (
    incident_id VARCHAR(20) PRIMARY KEY,
    title TEXT,
    summary TEXT,
    root_cause TEXT,
    resolution TEXT,
    severity VARCHAR(20),
    status VARCHAR(30),
    affected_services TEXT,
    started_at TIMESTAMP,
    resolved_at TIMESTAMP
);