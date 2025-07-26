# Demo Application

## About the Project

This Android application demonstrates a clean, maintainable, and well-architected implementation of a feature-rich education screen using **Jetpack Compose**, **Hilt Dependency Injection**, **Coroutines**, **Retrofit**, and **Clean Architecture** principles. The app fetches dynamic content from a remote API and presents it with sophisticated UI animations and interactions closely following a provided Figma design.

### Key Focus Areas

#### 1. Code Quality

- Ensure **clean, readable, and maintainable code** across all layers of the app — including data, domain, and presentation.
- Adhere strictly to **SOLID principles**, guaranteeing:
  - Clear separation of concerns between repository interfaces, use cases, ViewModel, and UI.
  - Single responsibility principle for all classes and composables.
- Consistently follow **Jetpack Compose idioms** and clean **state management** patterns.
- Utilize **Coroutines** correctly and efficiently for all asynchronous tasks such as network calls and data loading.
- Implement the **MVVM/MVI architecture patterns**:
  - The ViewModel holds all UI state.
  - Clear separation between domain logic and UI logic enabled by Clean Architecture layers.
- Modularize the codebase so that functions and composables remain highly testable and reusable.
- Handle errors gracefully and enforce null safety leveraging Kotlin language features.
- Provide meaningful comments and documentation for complex logic sections.
- Follow Kotlin coding conventions and leverage idiomatic Kotlin patterns throughout.

#### 2. Functionality

- Implement the UI to precisely **match the provided Figma prototype** in colors, typography, spacing, and layout.
- Include all **animations and transitions** as per design:
  - Smooth card expand/collapse animations.
  - Animated background color transitions.
  - Entry animations featuring zig-zag sliding and fade effects for cards.
- Ensure all **user interactions** behave exactly as expected:
  - Clickable buttons with correct navigation flows.
  - Expand and collapse functionality fully operational on cards.
- Complete implementation of all actionable UI elements:
  - Fully functional "Save in Gold" button.
  - Seamlessly integrated navigation between screens.
- Conduct thorough testing on various screen sizes to guarantee responsiveness and usability.
- Manage full support for **loading**, **error**, and **empty states** to deliver a polished user experience.

#### 3. Performance

- Optimize all **network calls** by:
  - Leveraging Retrofit effectively with proper API call management.
  - Implementing caching strategies where applicable.
  - Avoiding redundant or excessive API requests.
- Optimize **UI rendering performance**:
  - Use `remember` and Compose state APIs to minimize recompositions.
  - Employ lazy loading with `LazyColumn` and proper item keys for efficient list rendering.
- Manage coroutines with proper scopes and cancellation to prevent memory leaks.
- Monitor and optimize memory and CPU usage during animations and state updates to maintain smooth performance.

![WhatsApp Image 2025-07-26 at 10 48 21 PM (1)](https://github.com/user-attachments/assets/d0ab2128-9f32-4693-b81a-01b04e7c68f5)

![WhatsApp Image 2025-07-26 at 10 48 21 PM (2)](https://github.com/user-attachments/assets/4f1f0845-cc2e-4ae2-ab2c-108e3e63c4a9)

![WhatsApp Image 2025-07-26 at 10 48 21 PM](https://github.com/user-attachments/assets/da3292f8-e01f-4695-9593-f6bb822d08bb)

![WhatsApp Image 2025-07-26 at 10 48 22 PM](https://github.com/user-attachments/assets/99ebb501-d9b2-43f1-88bd-8cb7dbb0caee)

This architecture and coding approach ensures a robust, scalable, and maintainable Android application aligned with modern best practices and professional standards.


---

*Last updated: Saturday, July 26, 2025*
