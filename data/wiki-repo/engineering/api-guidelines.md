# API Guidelines

All internal APIs follow REST conventions.

## Standards

- JSON payloads only
- Versioned endpoints
- Correlation IDs required
- Structured error responses

## Error Code Conventions

- AUTH-* : Authentication issues
- DATA-* : Data processing issues
- GW-* : Gateway failures

## Rate Limiting

API Gateway enforces rate limits based on tenant tier.

## Security

Sensitive fields must never appear in logs.