# Kafka Lag Runbook

## Symptoms

- delayed analytics dashboards
- event backlog growth
- slow report generation

## Investigation Steps

1. Check consumer group lag
2. Verify broker health
3. Inspect retry queue growth

## Recovery

Scale analytics consumers horizontally.