# Authorization Model

Authorization is role-based and enforced at the API Gateway and service layer.

## Role Types

- PLATFORM_ADMIN
- SUPPORT_ENGINEER
- HR_MANAGER
- ANALYTICS_USER

## Access Control

Each request must contain:
- JWT token
- tenantId
- role claims

## Multi-Tenant Isolation

Tenant isolation is enforced using metadata filters and row-level security.

## Audit Logging

All privileged actions are logged to the Audit Service.