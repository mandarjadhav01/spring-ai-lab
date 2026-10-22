# Event Driven Architecture

NexaCorp uses Kafka for asynchronous communication.

## Topics

- user-events
- workflow-events
- analytics-events

## Common Problems

- consumer lag
- replay duplication
- schema mismatch

## Observability

All events are traced using correlation IDs.