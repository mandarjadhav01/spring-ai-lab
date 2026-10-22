# Service Dependency Map

## Identity Service

Depends on:
- PostgreSQL
- Redis
- Okta SSO

## Workflow Engine

Depends on:
- Kafka
- Notification Service

## Analytics Pipeline

Depends on:
- Kafka
- Data Warehouse

## Known Dependency Risks

Analytics failures can cascade into dashboard latency spikes.