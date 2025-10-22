# Customer Experience Hub

Self-service customer portal with real-time order tracking, delivery preferences management, and omnichannel communication platform for enhanced customer engagement.

## Overview

The Customer Experience Hub is a customer-facing component of the Paklog WMS/WES platform, providing end-customers with transparent visibility into their orders, seamless self-service capabilities, and personalized delivery experiences. In the age of Amazon Prime expectations, customers demand real-time visibility, flexible delivery options, and instant communication across multiple channels.

This service transforms the traditional warehouse management system from a backend operational tool into a customer-centric experience platform. By providing visual order tracking, proactive notifications, easy returns initiation, and delivery preference management, organizations can significantly improve customer satisfaction while reducing support call volume by 40-60%.

## Domain-Driven Design

### Bounded Context

The Customer Experience Hub bounded context is responsible for:
- Customer profile and preference management
- Real-time order tracking with visual timeline
- Returns initiation and tracking workflow
- Delivery preference and scheduling management
- Multi-channel notification orchestration (email, SMS, push)
- Customer support ticket integration
- Feedback and review collection
- Delivery exception communication

### Ubiquitous Language

- **Customer Profile**: Comprehensive customer information and preferences
- **Order Tracking**: Real-time visibility into order fulfillment status
- **Tracking Milestone**: Significant event in order lifecycle (picked, packed, shipped)
- **Delivery Preference**: Customer-specified delivery instructions and windows
- **Notification Channel**: Communication method (email, SMS, push, voice)
- **Communication Preference**: Customer's preferred notification settings
- **Delivery Exception**: Deviation from expected delivery (delay, address issue)
- **Self-Service Action**: Customer-initiated operation (returns, reschedule)
- **Engagement Score**: Measure of customer interaction and satisfaction
- **Support Ticket**: Customer inquiry or issue requiring assistance

### Core Domain Model

#### Aggregates

**CustomerProfile** (Aggregate Root)
- Manages customer identity and contact information
- Stores delivery addresses and preferences
- Tracks communication preferences
- Maintains engagement history

**OrderTracking**
- Provides real-time order status visibility
- Tracks fulfillment milestones and events
- Calculates estimated delivery times
- Manages tracking updates and notifications

**CommunicationPreference**
- Defines notification channel preferences
- Manages opt-in/opt-out settings
- Controls notification frequency
- Stores timezone and language preferences

**DeliveryPreference**
- Captures delivery time windows
- Stores special delivery instructions
- Manages alternative delivery locations
- Handles signature requirements

#### Value Objects

- `TrackingStatus`: RECEIVED, PICKING, PACKING, SHIPPED, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED
- `NotificationChannel`: EMAIL, SMS, PUSH_NOTIFICATION, VOICE, WEBHOOK
- `DeliveryWindow`: Preferred delivery time range
- `ContactMethod`: Customer contact information with verification status
- `Address`: Validated delivery or pickup address
- `EngagementMetric`: Tracking interaction score
- `FeedbackRating`: Customer satisfaction score
- `PreferenceType`: Delivery, notification, or service preference

#### Domain Events

- `TrackingRequestedEvent`: Customer requested order tracking
- `NotificationSentEvent`: Notification delivered to customer
- `DeliveryPreferenceUpdatedEvent`: Customer updated delivery preferences
- `ReturnInitiatedEvent`: Customer started return process
- `FeedbackSubmittedEvent`: Customer provided feedback
- `SupportTicketCreatedEvent`: Customer created support request
- `DeliveryRescheduledEvent`: Customer changed delivery time
- `ProfileUpdatedEvent`: Customer profile modified

## Architecture

This service follows Paklog's standard architecture patterns:
- **Hexagonal Architecture** (Ports and Adapters)
- **Domain-Driven Design** (DDD)
- **Event-Driven Architecture** with Apache Kafka
- **CloudEvents** specification for event formatting
- **CQRS** for command/query separation
- **BFF Pattern** (Backend for Frontend) for optimized API

### Project Structure

```
customer-experience-hub/
├── src/
│   ├── main/
│   │   ├── java/com/paklog/customer/experience/hub/
│   │   │   ├── domain/               # Core business logic
│   │   │   │   ├── aggregate/        # CustomerProfile, OrderTracking, CommunicationPreference
│   │   │   │   ├── entity/           # Supporting entities
│   │   │   │   ├── valueobject/      # TrackingStatus, NotificationChannel, Address
│   │   │   │   ├── service/          # Domain services
│   │   │   │   ├── repository/       # Repository interfaces (ports)
│   │   │   │   └── event/            # Domain events
│   │   │   ├── application/          # Use cases & orchestration
│   │   │   │   ├── port/
│   │   │   │   │   ├── in/           # Input ports (use cases)
│   │   │   │   │   └── out/          # Output ports
│   │   │   │   ├── service/          # Application services
│   │   │   │   ├── command/          # Commands
│   │   │   │   └── query/            # Queries
│   │   │   └── infrastructure/       # External adapters
│   │   │       ├── persistence/      # MongoDB repositories
│   │   │       ├── messaging/        # Kafka publishers/consumers
│   │   │       ├── web/              # REST & GraphQL controllers
│   │   │       ├── notification/     # SMS, email, push adapters
│   │   │       └── config/           # Configuration
│   │   └── resources/
│   │       └── application.yml       # Configuration
│   └── test/                         # Tests
├── frontend/                         # React customer portal
│   ├── src/
│   │   ├── components/              # React components
│   │   ├── pages/                   # Portal pages
│   │   ├── hooks/                   # Custom React hooks
│   │   └── services/                # API clients
│   └── package.json
├── k8s/                              # Kubernetes manifests
├── docker-compose.yml                # Local development
├── Dockerfile                        # Container definition
└── pom.xml                          # Maven configuration
```

## Features

### Core Capabilities

- **Real-Time Order Tracking**: Live updates with visual timeline and map integration
- **Self-Service Returns**: Easy returns initiation with label generation
- **Delivery Management**: Reschedule deliveries and update preferences
- **Multi-Channel Notifications**: Proactive updates via email, SMS, and push
- **Address Management**: Save and manage multiple delivery addresses
- **Order History**: Complete order archive with reorder capability
- **Preference Center**: Centralized communication and delivery preferences
- **Support Integration**: Integrated help desk and chatbot
- **Mobile-First Design**: Responsive design optimized for mobile devices
- **Personalization**: Tailored experience based on customer behavior

### Customer Portal Features

**Dashboard**
- Order summary and active shipments
- Recent notifications and alerts
- Quick actions (track, return, support)
- Personalized recommendations

**Order Tracking Page**
- Visual timeline with milestone markers
- Real-time location map (for supported carriers)
- Estimated delivery time with confidence indicator
- Shipment photos and proof of delivery
- Carrier contact information

**Returns Center**
- Return eligibility check
- Easy return reason selection
- Automatic label generation
- Return status tracking
- Refund timeline visibility

**Delivery Preferences**
- Delivery window selection
- Special instructions (gate code, safe place)
- Alternative delivery locations
- Signature requirements
- Vacation hold settings

**Communication Center**
- Notification history
- Channel preferences (email, SMS, push)
- Frequency controls
- Language and timezone settings
- Opt-out management

## Technology Stack

- **Java 21** - Backend programming language
- **Spring Boot 3.2.5** - Backend framework
- **React 18** - Frontend framework
- **TypeScript** - Frontend type safety
- **MongoDB** - Customer profiles and preferences
- **Redis** - Session management and caching
- **Apache Kafka** - Event streaming
- **CloudEvents 2.5.0** - Event format specification
- **GraphQL** - Flexible API for frontend
- **WebSocket** - Real-time updates
- **Twilio** - SMS notifications
- **SendGrid** - Email delivery
- **Firebase** - Push notifications

## Getting Started

### Prerequisites

- Java 21+
- Node.js 18+
- Maven 3.8+
- Docker & Docker Compose
- MongoDB 7.0+
- Redis 7.2+
- Apache Kafka 3.5+

### Local Development

1. **Clone the repository**
```bash
git clone https://github.com/paklog/customer-experience-hub.git
cd customer-experience-hub
```

2. **Start infrastructure services**
```bash
docker-compose up -d mongodb redis kafka
```

3. **Build the backend**
```bash
mvn clean install
```

4. **Run the backend**
```bash
mvn spring-boot:run
```

5. **Install frontend dependencies**
```bash
cd frontend
npm install
```

6. **Run the frontend**
```bash
npm start
```

7. **Access the portal**
- Backend API: http://localhost:8101
- Customer Portal: http://localhost:3000

### Using Docker Compose

```bash
# Start all services including frontend and backend
docker-compose up -d

# View logs
docker-compose logs -f customer-experience-hub

# Stop all services
docker-compose down
```

## API Documentation

Once running, access the interactive API documentation:
- **Swagger UI**: http://localhost:8101/swagger-ui.html
- **GraphQL Playground**: http://localhost:8101/graphql
- **OpenAPI Spec**: http://localhost:8101/v3/api-docs

### Key Endpoints

#### Customer Profile Management
- `POST /api/v1/customers/register` - Register new customer
- `GET /api/v1/customers/{customerId}` - Get customer profile
- `PUT /api/v1/customers/{customerId}` - Update customer profile
- `DELETE /api/v1/customers/{customerId}` - Delete customer account

#### Order Tracking
- `GET /api/v1/tracking/{orderId}` - Get order tracking details
- `GET /api/v1/tracking/{orderId}/timeline` - Get order timeline events
- `GET /api/v1/tracking/{orderId}/location` - Get real-time shipment location
- `POST /api/v1/tracking/{orderId}/subscribe` - Subscribe to tracking updates

#### Returns Management
- `POST /api/v1/returns/check-eligibility` - Check if order is returnable
- `POST /api/v1/returns/initiate` - Start return process
- `GET /api/v1/returns/{returnId}` - Get return status
- `GET /api/v1/returns/{returnId}/label` - Download return label

#### Delivery Preferences
- `GET /api/v1/preferences/delivery` - Get delivery preferences
- `PUT /api/v1/preferences/delivery` - Update delivery preferences
- `POST /api/v1/preferences/delivery/window` - Set delivery time window
- `PUT /api/v1/preferences/delivery/instructions` - Update special instructions

#### Communication Preferences
- `GET /api/v1/preferences/communication` - Get notification preferences
- `PUT /api/v1/preferences/communication` - Update notification settings
- `POST /api/v1/preferences/communication/opt-out` - Opt out of notifications
- `POST /api/v1/preferences/communication/opt-in` - Opt in to notifications

#### Address Management
- `GET /api/v1/addresses` - List customer addresses
- `POST /api/v1/addresses` - Add new address
- `PUT /api/v1/addresses/{addressId}` - Update address
- `DELETE /api/v1/addresses/{addressId}` - Remove address
- `PUT /api/v1/addresses/{addressId}/default` - Set default address

#### Support & Feedback
- `POST /api/v1/support/tickets` - Create support ticket
- `GET /api/v1/support/tickets/{ticketId}` - Get ticket status
- `POST /api/v1/feedback` - Submit feedback
- `GET /api/v1/support/faq` - Get FAQ articles

### GraphQL API

```graphql
type Query {
  orderTracking(orderId: ID!): OrderTracking
  customerProfile(customerId: ID!): CustomerProfile
  deliveryPreferences(customerId: ID!): DeliveryPreferences
  orderHistory(customerId: ID!, limit: Int): [Order]
}

type Mutation {
  updateDeliveryPreferences(input: DeliveryPreferencesInput!): DeliveryPreferences
  initiateReturn(input: ReturnInitiationInput!): Return
  createSupportTicket(input: SupportTicketInput!): SupportTicket
  submitFeedback(input: FeedbackInput!): Feedback
}

type Subscription {
  orderTrackingUpdates(orderId: ID!): TrackingUpdate
  notificationReceived(customerId: ID!): Notification
}
```

## Configuration

Key configuration properties in `application.yml`:

```yaml
customer:
  experience:
    portal:
      base-url: https://track.paklog.com
      session-timeout-minutes: 30
      max-addresses-per-customer: 10

    tracking:
      real-time-updates-enabled: true
      update-interval-seconds: 30
      carrier-api-integration: true
      map-provider: GOOGLE_MAPS

    notifications:
      providers:
        email:
          provider: SENDGRID
          api-key: ${SENDGRID_API_KEY}
          from-address: noreply@paklog.com
        sms:
          provider: TWILIO
          account-sid: ${TWILIO_ACCOUNT_SID}
          auth-token: ${TWILIO_AUTH_TOKEN}
          from-number: +1234567890
        push:
          provider: FIREBASE
          project-id: paklog-customer-portal
          credentials: ${FIREBASE_CREDENTIALS}

    returns:
      self-service-enabled: true
      max-return-window-days: 30
      auto-approve-threshold: 100.00
      label-generation-enabled: true

    support:
      chatbot-enabled: true
      live-chat-hours: 9-17
      ticket-auto-response: true
```

## Event Integration

### Published Events

- `TrackingRequestedEvent` - Customer accessed order tracking
- `NotificationSentEvent` - Notification delivered to customer
- `DeliveryPreferenceUpdatedEvent` - Delivery preferences changed
- `ReturnInitiatedEvent` - Customer started return
- `FeedbackSubmittedEvent` - Customer feedback received
- `SupportTicketCreatedEvent` - Support request created
- `DeliveryRescheduledEvent` - Delivery time changed
- `ProfileUpdatedEvent` - Customer profile modified

### Consumed Events

- `OrderCreatedEvent` from Order Management (enable tracking)
- `OrderShippedEvent` from Shipment Service (tracking milestone)
- `DeliveryAttemptedEvent` from Last-Mile Delivery (delivery status)
- `ReturnApprovedEvent` from Returns Management (return status)
- `RefundProcessedEvent` from Financial Settlement (refund notification)

## Deployment

### Kubernetes Deployment

```bash
# Create namespace
kubectl create namespace paklog-customer-experience

# Apply configurations
kubectl apply -f k8s/deployment.yaml

# Check deployment status
kubectl get pods -n paklog-customer-experience
```

### Production Considerations

- **Scaling**: Horizontal scaling via Kubernetes HPA based on traffic
- **High Availability**: Deploy minimum 3 replicas across zones
- **Resource Requirements**:
  - Backend: Memory 1 GB, CPU 0.5 core per instance
  - Frontend: Served via CDN (Cloudflare/AWS CloudFront)
- **CDN Configuration**: Static assets cached globally
- **Session Management**: Redis cluster for distributed sessions
- **Monitoring**: Real User Monitoring (RUM) with performance tracking

## Testing

```bash
# Run backend unit tests
mvn test

# Run backend integration tests
mvn verify

# Run frontend tests
cd frontend && npm test

# Run E2E tests
cd frontend && npm run test:e2e

# Run with coverage
mvn clean verify jacoco:report
cd frontend && npm run test:coverage
```

### Test Coverage Requirements
- Backend Unit Tests: >80%
- Backend Integration Tests: >70%
- Frontend Unit Tests: >75%
- E2E Tests: Critical user journeys covered

## Performance

### Benchmarks
- **API Latency**: p99 < 100ms for tracking requests
- **Portal Load Time**: < 2 seconds first contentful paint
- **Real-Time Updates**: < 500ms update delivery via WebSocket
- **Notification Delivery**: < 5 seconds for email/SMS
- **Search Performance**: < 200ms for order history queries
- **Concurrent Users**: 100,000+ simultaneous portal users

### Optimization Techniques
- Redis caching for frequently accessed data
- CDN delivery for static assets
- GraphQL query batching and caching
- Lazy loading for order history
- Service worker for offline capability
- Image optimization and lazy loading
- Code splitting for faster initial load

## Monitoring & Observability

### Metrics
- Portal active users
- Order tracking requests
- Notification delivery rate
- Return initiation rate
- Support ticket volume
- Customer engagement score
- Page load performance
- API response times

### Health Checks
- `/actuator/health` - Overall health
- `/actuator/health/liveness` - Kubernetes liveness
- `/actuator/health/readiness` - Kubernetes readiness
- `/actuator/health/notification-services` - External service status

### Distributed Tracing
OpenTelemetry integration tracking customer interactions end-to-end.

### Analytics Integration
- Google Analytics for portal usage
- Mixpanel for customer behavior tracking
- Hotjar for heatmaps and recordings
- Custom event tracking for funnel analysis

## Business Impact

- **Support Cost Reduction**: -50% reduction in "where is my order" calls
- **Customer Satisfaction**: +20 NPS improvement with tracking visibility
- **Return Rate**: -15% reduction through easy self-service returns
- **Delivery Success**: +25% increase in first-attempt delivery success
- **Brand Loyalty**: +30% increase in repeat purchase rate
- **Mobile Engagement**: 70% of tracking requests from mobile devices
- **Self-Service Adoption**: 85% of customers use portal vs. calling support

## User Experience Design

### Mobile-First Approach
- Responsive design for all screen sizes
- Touch-optimized interactions
- Simplified navigation for mobile
- Progressive Web App (PWA) capabilities
- Offline order history access

### Accessibility (WCAG 2.1 Level AA)
- Keyboard navigation support
- Screen reader compatibility
- High contrast mode
- Font size adjustment
- Alternative text for images
- ARIA labels for dynamic content

### Personalization
- Saved delivery preferences
- Frequently used addresses
- Recommended delivery windows
- Personalized notifications
- Order history patterns
- Predictive search

## Notification Strategy

### Notification Types

**Transactional Notifications**
- Order confirmation
- Shipment tracking updates
- Delivery confirmation
- Return approval
- Refund processed

**Promotional Notifications** (opt-in)
- Special offers
- New features
- Seasonal promotions
- Loyalty rewards

**Service Notifications**
- Delivery exceptions
- Address issues
- Weather delays
- Support responses

### Multi-Channel Orchestration
```java
public void sendNotification(Notification notification) {
    // Intelligent channel selection based on:
    // - Customer preference
    // - Notification urgency
    // - Time of day
    // - Previous engagement

    if (notification.isUrgent() && customer.hasSMSEnabled()) {
        smsService.send(notification);
    } else if (customer.hasEmailEnabled()) {
        emailService.send(notification);
    }

    if (customer.hasPushEnabled()) {
        pushService.send(notification);
    }
}
```

## Troubleshooting

### Common Issues

1. **Tracking Updates Not Displaying**
   - Check WebSocket connection status
   - Verify Kafka event consumption
   - Review carrier API integration
   - Examine Redis cache invalidation
   - Check customer subscription status

2. **Notification Delivery Failures**
   - Verify third-party service credentials
   - Check customer contact information validity
   - Review notification service health
   - Examine retry queue status
   - Validate customer opt-in status

3. **Portal Performance Issues**
   - Review CDN cache hit ratio
   - Check Redis connection pool
   - Examine database query performance
   - Verify frontend bundle size
   - Review API response caching

4. **Return Initiation Errors**
   - Verify order eligibility rules
   - Check returns service integration
   - Review label generation service
   - Examine refund calculation logic
   - Validate customer authentication

## Security Considerations

### Authentication & Authorization
- OAuth 2.0 / OpenID Connect integration
- Multi-factor authentication support
- JWT token-based session management
- Role-based access control (RBAC)
- API rate limiting per customer

### Data Protection
- PII encryption at rest and in transit
- GDPR compliance (right to be forgotten)
- CCPA compliance (data privacy)
- Secure password hashing (bcrypt)
- Regular security audits

### API Security
- API key rotation
- Request signature validation
- CORS policy enforcement
- SQL injection prevention
- XSS protection

## Integration Points

### Order Management System
- Order creation and status updates
- Order history retrieval
- Reorder functionality
- Order modification requests

### Returns Management
- Return eligibility checking
- Return initiation workflow
- Return status tracking
- Refund status visibility

### Last-Mile Delivery
- Real-time delivery tracking
- Delivery rescheduling
- Delivery photo access
- Proof of delivery retrieval

### Payment Gateway
- Refund status checking
- Payment method management
- Transaction history
- Billing address updates

## Future Enhancements

### Planned Features
- AI-powered chatbot for support
- Voice assistant integration (Alexa, Google)
- Augmented reality package tracking
- Predictive delivery notifications
- Social media tracking integration
- Cryptocurrency payment support
- Sustainability impact dashboard

## Contributing

1. Follow hexagonal architecture principles
2. Maintain domain logic in domain layer
3. Keep infrastructure concerns separate
4. Write comprehensive tests for all changes
5. Follow accessibility guidelines (WCAG 2.1)
6. Optimize for mobile-first experience
7. Document user-facing features

## Support

For issues and questions:
- Create an issue in GitHub
- Contact the Paklog Customer Experience Team
- Check the [documentation](https://paklog.github.io/docs/customer-experience)
- Review [API integration guide](https://paklog.github.io/docs/api)

## License

Copyright © 2024 Paklog. All rights reserved.

---

**Version**: 1.0.0
**Phase**: 4 (Excellence)
**Priority**: P3 (Differentiation)
**Maintained by**: Paklog Customer Experience Team
**Last Updated**: November 2024
