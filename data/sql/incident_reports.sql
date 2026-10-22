INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-501',
    'Production VPN Connectivity Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Stale gateway cache after deployment rollout.',
    'Rotated certificates and refreshed Identity Service.',
    'SEV-3',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-04-28 00:00:00',
    '2026-04-29 10:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-502',
    'Analytics Dashboard Delay',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Database connection pool exhaustion during traffic spike.',
    'Cleared gateway cache and restarted API gateway.',
    'SEV-1',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-04-27 00:00:00',
    '2026-04-27 18:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-503',
    'SSO Authentication Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'OAuth signing certificate rotation mismatch.',
    'Increased DB connection pool size and rebalanced traffic.',
    'SEV-3',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-02-10 00:00:00',
    '2026-02-10 20:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-504',
    'Kafka Consumer Backlog',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'OAuth signing certificate rotation mismatch.',
    'Scaled analytics consumers horizontally.',
    'SEV-1',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-04-16 00:00:00',
    '2026-04-16 09:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-505',
    'Production VPN Connectivity Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Stale gateway cache after deployment rollout.',
    'Increased DB connection pool size and rebalanced traffic.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-02-19 00:00:00',
    '2026-02-19 02:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-506',
    'Kafka Consumer Backlog',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Stale gateway cache after deployment rollout.',
    'Increased DB connection pool size and rebalanced traffic.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-03-21 00:00:00',
    '2026-03-21 04:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-507',
    'Production VPN Connectivity Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'OAuth signing certificate rotation mismatch.',
    'Scaled analytics consumers horizontally.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-02-25 00:00:00',
    '2026-02-25 16:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-508',
    'SSO Authentication Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Stale gateway cache after deployment rollout.',
    'Rotated certificates and refreshed Identity Service.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-02-12 00:00:00',
    '2026-02-13 03:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-509',
    'Kafka Consumer Backlog',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Stale gateway cache after deployment rollout.',
    'Rotated certificates and refreshed Identity Service.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-03-26 00:00:00',
    '2026-03-26 06:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-510',
    'SSO Authentication Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'OAuth signing certificate rotation mismatch.',
    'Scaled analytics consumers horizontally.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-01-11 00:00:00',
    '2026-01-12 11:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-511',
    'SEV-1 Gateway Timeout Surge',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Kafka broker overload caused consumer lag escalation.',
    'Increased DB connection pool size and rebalanced traffic.',
    'SEV-3',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-04-29 00:00:00',
    '2026-04-29 12:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-512',
    'Analytics Dashboard Delay',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Kafka broker overload caused consumer lag escalation.',
    'Cleared gateway cache and restarted API gateway.',
    'SEV-1',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-01-06 00:00:00',
    '2026-01-06 09:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-513',
    'Kafka Consumer Backlog',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'OAuth signing certificate rotation mismatch.',
    'Rotated certificates and refreshed Identity Service.',
    'SEV-1',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-04-18 00:00:00',
    '2026-04-19 03:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-514',
    'SSO Authentication Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Database connection pool exhaustion during traffic spike.',
    'Cleared gateway cache and restarted API gateway.',
    'SEV-3',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-03-07 00:00:00',
    '2026-03-08 08:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-515',
    'SSO Authentication Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'OAuth signing certificate rotation mismatch.',
    'Increased DB connection pool size and rebalanced traffic.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-02-18 00:00:00',
    '2026-02-18 10:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-516',
    'Kafka Consumer Backlog',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'OAuth signing certificate rotation mismatch.',
    'Increased DB connection pool size and rebalanced traffic.',
    'SEV-3',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-03-07 00:00:00',
    '2026-03-08 00:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-517',
    'SSO Authentication Failure',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Kafka broker overload caused consumer lag escalation.',
    'Rotated certificates and refreshed Identity Service.',
    'SEV-1',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-01-12 00:00:00',
    '2026-01-13 08:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-518',
    'Analytics Dashboard Delay',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Database connection pool exhaustion during traffic spike.',
    'Scaled analytics consumers horizontally.',
    'SEV-3',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-03-04 00:00:00',
    '2026-03-05 09:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-519',
    'Analytics Dashboard Delay',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Kafka broker overload caused consumer lag escalation.',
    'Cleared gateway cache and restarted API gateway.',
    'SEV-2',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-02-09 00:00:00',
    '2026-02-10 10:00:00'
);

INSERT INTO incident_reports (
    incident_id, title, summary, root_cause,
    resolution, severity, status,
    affected_services, started_at, resolved_at
) VALUES (
    'INC-520',
    'SEV-1 Gateway Timeout Surge',
    'A production incident impacted enterprise tenants.
Customers experienced degraded platform functionality and intermittent failures.
Support teams observed elevated error rates and authentication instability.',
    'Database connection pool exhaustion during traffic spike.',
    'Rotated certificates and refreshed Identity Service.',
    'SEV-1',
    'RESOLVED',
    'API Gateway, Identity Service, Analytics Pipeline',
    '2026-02-06 00:00:00',
    '2026-02-06 06:00:00'
);