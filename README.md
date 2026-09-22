# hexagonal-hsa-poc

Spring Boot proof-of-concept built with a hexagonal architecture (`domain`, `web`, `postcode`, `application` modules).

- `domain` — business logic: models, inbound ports (use cases), outbound ports, and the services implementing them. Depends on nothing web- or infrastructure-specific.
- `web` — inbound adapter: REST controllers, request/response DTOs, and DTO↔domain mappers.
- `postcode` — outbound adapter implementing `domain`'s `PostcodeLookupClient` port by calling the public [postcodes.io](https://postcodes.io) API.
- `application` — composition root: the only module that depends on both `web` and `postcode`, and boots Spring.

## Running the app

```bash
./gradlew bootRun
```

The app starts on `http://localhost:8080`.

## API

### Create a quote

```
POST /quotes
Content-Type: application/json
```

**Request body**

| Field         | Type    | Constraints        |
|---------------|---------|---------------------|
| customerName  | string  | required, non-blank |
| basePremium   | decimal | required, >= 0.0    |

**Sample request**

```bash
curl -X POST http://localhost:8080/quotes \
  -H "Content-Type: application/json" \
  -d '{"customerName":"Test User","basePremium":100.00}'
```

**Sample response** — `200 OK`

```json
{
  "id": "fde56434-9049-4331-b9e2-b2f3b3771cfd",
  "customerName": "Test User",
  "premium": 125.00
}
```

### Get postcode details

```
GET /postcodes/{postcode}
```

**Sample request**

```bash
curl http://localhost:8080/postcodes/SW1A1AA
```

**Sample response** — `200 OK`

```json
{
  "postcode": "SW1A 1AA",
  "region": "London",
  "adminDistrict": "Westminster",
  "latitude": 51.50101,
  "longitude": -0.141563
}
```

If the postcode is not found, the endpoint returns `404 Not Found`.
