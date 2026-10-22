# Deployment Architecture

The NexaCorp platform is deployed using Kubernetes.

## Components

- API Gateway
- Identity Service
- Workflow Engine
- PostgreSQL
- Redis
- Kafka

## Production Regions

- us-east-1
- eu-west-1

## Deployment Strategy

Blue-green deployments are used for customer-facing services.

## Known Issues

Gateway timeout spikes sometimes occur during large deployments.