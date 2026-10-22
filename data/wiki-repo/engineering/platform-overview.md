# NexaCorp Platform Overview

NexaCorp provides a cloud-native workflow automation and analytics platform used by enterprise customers in healthcare, retail, and logistics.

## Core Platform Services

- API Gateway
- Identity Service
- Workflow Engine
- Notification Service
- Analytics Pipeline
- Audit Service

## Deployment Model

All production workloads run on Kubernetes clusters hosted in AWS.

## Authentication Flow

Authentication is handled through the Identity Service using OAuth2 and JWT access tokens.

## Common Operational Issues

- AUTH-403 errors after SSO migrations
- Kafka lag spikes in analytics processing
- Gateway timeout errors during deployment rollouts

## Internal Tools

- NexaAdmin
- Audit Console
- Deployment Dashboard