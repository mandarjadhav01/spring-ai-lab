INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1001',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Kafka',
    'PRODUCTION',
    'Security',
    'TENANT_ALPHA',
    '2026-02-07 00:00:00',
    '2026-02-08 02:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1002',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Kafka',
    'STAGING',
    'Infrastructure',
    'TENANT_ALPHA',
    '2026-02-27 00:00:00',
    '2026-03-01 09:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1003',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'HIGH',
    'Payroll',
    'STAGING',
    'Analytics',
    'TENANT_GAMMA',
    '2026-04-27 00:00:00',
    '2026-04-29 05:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1004',
    'AUTH-403 after Okta migration',
    'Users reported issue related to auth-403 after okta migration.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Authentication',
    'STAGING',
    'Security',
    'TENANT_GAMMA',
    '2026-04-28 00:00:00',
    '2026-04-29 11:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1005',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'VPN',
    'PRODUCTION',
    'Support',
    'TENANT_BETA',
    '2026-01-15 00:00:00',
    '2026-01-16 21:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1006',
    'Refresh token rotation issue',
    'Users reported issue related to refresh token rotation issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'Authentication',
    'STAGING',
    'Infrastructure',
    'TENANT_ALPHA',
    '2026-04-16 00:00:00',
    '2026-04-16 17:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1007',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Gateway',
    'PRODUCTION',
    'Support',
    'TENANT_BETA',
    '2026-01-08 00:00:00',
    '2026-01-09 19:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1008',
    'MFA verification failure',
    'Users reported issue related to mfa verification failure.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'Security',
    'STAGING',
    'Infrastructure',
    'TENANT_GAMMA',
    '2026-05-03 00:00:00',
    '2026-05-05 23:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1009',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'MEDIUM',
    'Gateway',
    'PRODUCTION',
    'Analytics',
    'TENANT_GAMMA',
    '2026-03-20 00:00:00',
    '2026-03-22 01:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1010',
    'MFA verification failure',
    'Users reported issue related to mfa verification failure.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'LOW',
    'Security',
    'STAGING',
    'Analytics',
    'TENANT_BETA',
    '2026-03-24 00:00:00',
    '2026-03-25 04:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1011',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'HIGH',
    'Payroll',
    'STAGING',
    'Security',
    'TENANT_GAMMA',
    '2026-02-11 00:00:00',
    '2026-02-13 04:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1012',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'HIGH',
    'Gateway',
    'PRODUCTION',
    'Infrastructure',
    'TENANT_ALPHA',
    '2026-01-21 00:00:00',
    '2026-01-22 03:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1013',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'LOW',
    'Gateway',
    'STAGING',
    'Support',
    'TENANT_ALPHA',
    '2026-03-02 00:00:00',
    '2026-03-03 00:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1014',
    'AUTH-403 after Okta migration',
    'Users reported issue related to auth-403 after okta migration.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'LOW',
    'Authentication',
    'PRODUCTION',
    'Support',
    'TENANT_GAMMA',
    '2026-01-06 00:00:00',
    '2026-01-07 12:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1015',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'LOW',
    'VPN',
    'PRODUCTION',
    'Security',
    'TENANT_BETA',
    '2026-01-19 00:00:00',
    '2026-01-20 12:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1016',
    'Dashboard metrics delayed',
    'Users reported issue related to dashboard metrics delayed.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'Analytics',
    'PRODUCTION',
    'Security',
    'TENANT_GAMMA',
    '2026-01-14 00:00:00',
    '2026-01-15 08:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1017',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'LOW',
    'Kafka',
    'STAGING',
    'Platform',
    'TENANT_ALPHA',
    '2026-03-17 00:00:00',
    '2026-03-18 13:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1018',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'Payroll',
    'STAGING',
    'Infrastructure',
    'TENANT_BETA',
    '2026-04-18 00:00:00',
    '2026-04-20 21:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1019',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'VPN',
    'PRODUCTION',
    'Security',
    'TENANT_GAMMA',
    '2026-02-03 00:00:00',
    '2026-02-04 16:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1020',
    'AUTH-403 after Okta migration',
    'Users reported issue related to auth-403 after okta migration.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'MEDIUM',
    'Authentication',
    'PRODUCTION',
    'Support',
    'TENANT_GAMMA',
    '2026-04-03 00:00:00',
    '2026-04-03 19:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1021',
    'Dashboard metrics delayed',
    'Users reported issue related to dashboard metrics delayed.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'LOW',
    'Analytics',
    'STAGING',
    'Platform',
    'TENANT_BETA',
    '2026-03-10 00:00:00',
    '2026-03-11 12:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1022',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Payroll',
    'STAGING',
    'Platform',
    'TENANT_BETA',
    '2026-03-07 00:00:00',
    '2026-03-08 03:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1023',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Gateway',
    'PRODUCTION',
    'Infrastructure',
    'TENANT_ALPHA',
    '2026-04-30 00:00:00',
    '2026-04-30 19:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1024',
    'MFA verification failure',
    'Users reported issue related to mfa verification failure.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Security',
    'PRODUCTION',
    'Platform',
    'TENANT_BETA',
    '2026-01-31 00:00:00',
    '2026-01-31 12:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1025',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'LOW',
    'Gateway',
    'PRODUCTION',
    'Support',
    'TENANT_BETA',
    '2026-02-07 00:00:00',
    '2026-02-09 01:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1026',
    'MFA verification failure',
    'Users reported issue related to mfa verification failure.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'LOW',
    'Security',
    'STAGING',
    'Security',
    'TENANT_GAMMA',
    '2026-04-18 00:00:00',
    '2026-04-20 03:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1027',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'LOW',
    'VPN',
    'PRODUCTION',
    'Infrastructure',
    'TENANT_ALPHA',
    '2026-04-11 00:00:00',
    '2026-04-13 09:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1028',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Payroll',
    'PRODUCTION',
    'Analytics',
    'TENANT_BETA',
    '2026-03-21 00:00:00',
    '2026-03-23 17:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1029',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Gateway',
    'STAGING',
    'Security',
    'TENANT_ALPHA',
    '2026-02-23 00:00:00',
    '2026-02-25 13:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1030',
    'Refresh token rotation issue',
    'Users reported issue related to refresh token rotation issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'MEDIUM',
    'Authentication',
    'STAGING',
    'Infrastructure',
    'TENANT_GAMMA',
    '2026-03-21 00:00:00',
    '2026-03-22 19:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1031',
    'Refresh token rotation issue',
    'Users reported issue related to refresh token rotation issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Authentication',
    'STAGING',
    'Analytics',
    'TENANT_GAMMA',
    '2026-03-10 00:00:00',
    '2026-03-10 02:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1032',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'LOW',
    'Payroll',
    'PRODUCTION',
    'Support',
    'TENANT_ALPHA',
    '2026-04-07 00:00:00',
    '2026-04-08 10:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1033',
    'MFA verification failure',
    'Users reported issue related to mfa verification failure.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'MEDIUM',
    'Security',
    'STAGING',
    'Analytics',
    'TENANT_BETA',
    '2026-02-26 00:00:00',
    '2026-02-26 16:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1034',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'LOW',
    'VPN',
    'PRODUCTION',
    'Support',
    'TENANT_BETA',
    '2026-04-05 00:00:00',
    '2026-04-05 23:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1035',
    'Refresh token rotation issue',
    'Users reported issue related to refresh token rotation issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'LOW',
    'Authentication',
    'PRODUCTION',
    'Security',
    'TENANT_GAMMA',
    '2026-04-08 00:00:00',
    '2026-04-08 14:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1036',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'VPN',
    'PRODUCTION',
    'Support',
    'TENANT_GAMMA',
    '2026-01-06 00:00:00',
    '2026-01-08 05:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1037',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'HIGH',
    'Kafka',
    'PRODUCTION',
    'Security',
    'TENANT_ALPHA',
    '2026-02-15 00:00:00',
    '2026-02-16 07:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1038',
    'MFA verification failure',
    'Users reported issue related to mfa verification failure.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'Security',
    'PRODUCTION',
    'Security',
    'TENANT_ALPHA',
    '2026-03-09 00:00:00',
    '2026-03-09 15:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1039',
    'Refresh token rotation issue',
    'Users reported issue related to refresh token rotation issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'Authentication',
    'PRODUCTION',
    'Security',
    'TENANT_ALPHA',
    '2026-04-12 00:00:00',
    '2026-04-13 12:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1040',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'LOW',
    'Payroll',
    'STAGING',
    'Support',
    'TENANT_BETA',
    '2026-01-30 00:00:00',
    '2026-01-31 00:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1041',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'HIGH',
    'Kafka',
    'STAGING',
    'Platform',
    'TENANT_BETA',
    '2026-03-27 00:00:00',
    '2026-03-27 03:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1042',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'LOW',
    'Payroll',
    'PRODUCTION',
    'Analytics',
    'TENANT_GAMMA',
    '2026-01-30 00:00:00',
    '2026-01-31 16:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1043',
    'MFA verification failure',
    'Users reported issue related to mfa verification failure.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'LOW',
    'Security',
    'PRODUCTION',
    'Platform',
    'TENANT_ALPHA',
    '2026-05-03 00:00:00',
    '2026-05-03 03:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1044',
    'Dashboard metrics delayed',
    'Users reported issue related to dashboard metrics delayed.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'Analytics',
    'STAGING',
    'Security',
    'TENANT_BETA',
    '2026-03-21 00:00:00',
    '2026-03-21 12:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1045',
    'Dashboard metrics delayed',
    'Users reported issue related to dashboard metrics delayed.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'MEDIUM',
    'Analytics',
    'PRODUCTION',
    'Infrastructure',
    'TENANT_ALPHA',
    '2026-02-08 00:00:00',
    '2026-02-09 23:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1046',
    'Payroll CSV encoding issue',
    'Users reported issue related to payroll csv encoding issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'Payroll',
    'STAGING',
    'Analytics',
    'TENANT_ALPHA',
    '2026-02-08 00:00:00',
    '2026-02-10 17:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1047',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'VPN',
    'STAGING',
    'Infrastructure',
    'TENANT_GAMMA',
    '2026-05-04 00:00:00',
    '2026-05-04 14:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1048',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'MEDIUM',
    'Kafka',
    'STAGING',
    'Infrastructure',
    'TENANT_GAMMA',
    '2026-04-14 00:00:00',
    '2026-04-14 19:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1049',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'LOW',
    'Gateway',
    'PRODUCTION',
    'Support',
    'TENANT_ALPHA',
    '2026-02-14 00:00:00',
    '2026-02-14 15:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1050',
    'Refresh token rotation issue',
    'Users reported issue related to refresh token rotation issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'MEDIUM',
    'Authentication',
    'STAGING',
    'Support',
    'TENANT_BETA',
    '2026-02-19 00:00:00',
    '2026-02-21 11:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1051',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'HIGH',
    'Kafka',
    'PRODUCTION',
    'Analytics',
    'TENANT_GAMMA',
    '2026-04-30 00:00:00',
    '2026-05-01 14:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1052',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'HIGH',
    'Gateway',
    'STAGING',
    'Analytics',
    'TENANT_GAMMA',
    '2026-02-12 00:00:00',
    '2026-02-14 04:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1053',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in STAGING environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'LOW',
    'Gateway',
    'PRODUCTION',
    'Platform',
    'TENANT_BETA',
    '2026-04-25 00:00:00',
    '2026-04-27 08:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1054',
    'Refresh token rotation issue',
    'Users reported issue related to refresh token rotation issue.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'Authentication',
    'STAGING',
    'Infrastructure',
    'TENANT_GAMMA',
    '2026-03-13 00:00:00',
    '2026-03-15 08:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1055',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'HIGH',
    'Gateway',
    'STAGING',
    'Platform',
    'TENANT_GAMMA',
    '2026-04-02 00:00:00',
    '2026-04-03 10:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1056',
    'Dashboard metrics delayed',
    'Users reported issue related to dashboard metrics delayed.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'OPEN',
    'HIGH',
    'Analytics',
    'STAGING',
    'Infrastructure',
    'TENANT_BETA',
    '2026-03-03 00:00:00',
    '2026-03-04 05:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1057',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'VPN',
    'PRODUCTION',
    'Security',
    'TENANT_BETA',
    '2026-03-17 00:00:00',
    '2026-03-19 06:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1058',
    'Kafka lag spike in analytics pipeline',
    'Users reported issue related to kafka lag spike in analytics pipeline.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'MEDIUM',
    'Kafka',
    'STAGING',
    'Infrastructure',
    'TENANT_GAMMA',
    '2026-04-04 00:00:00',
    '2026-04-05 05:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1059',
    'Gateway timeout during deployment',
    'Users reported issue related to gateway timeout during deployment.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'IN_PROGRESS',
    'MEDIUM',
    'Gateway',
    'PRODUCTION',
    'Support',
    'TENANT_ALPHA',
    '2026-03-09 00:00:00',
    '2026-03-11 11:00:00'
);

INSERT INTO support_tickets (
    ticket_id, title, description, status, priority,
    category, environment, assigned_team, tenant_id,
    created_at, updated_at
) VALUES (
    'TKT-1060',
    'VPN timeout for remote employees',
    'Users reported issue related to vpn timeout for remote employees.
Problem appears intermittently in PRODUCTION environment.
Multiple employees unable to access internal systems after recent deployment.
Observed correlation with stale gateway cache and OAuth scope validation failures.
Some users reported AUTH-403 while others experienced login timeout behavior.',
    'RESOLVED',
    'HIGH',
    'VPN',
    'PRODUCTION',
    'Platform',
    'TENANT_ALPHA',
    '2026-03-14 00:00:00',
    '2026-03-16 20:00:00'
);