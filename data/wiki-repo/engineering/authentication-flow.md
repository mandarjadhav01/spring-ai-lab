# Authentication Flow

NexaCorp uses OAuth2 with JWT access tokens for all internal and external APIs.

## Login Sequence

1. User authenticates through Okta SSO
2. Identity Service validates credentials
3. Access token and refresh token are generated
4. API Gateway validates JWT signatures

## Common Errors

### AUTH-403

Usually triggered after SSO migration or stale gateway cache.

### TOKEN-401

Occurs when refresh token rotation fails.

## Troubleshooting

- Verify gateway cache refresh
- Validate OAuth scopes
- Check clock skew between services