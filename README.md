<h1 align="center" style="color:#008080;">SustainiamAssignment - Expense Calculation App</h1>

<h2 align="center" style="color:#1E90FF;">Description</h2>


Our app is an efficient expense calculation tool that enables users to obtain paid annual reports. The application flow begins with **JWT Authentication** for secure user login. Users are then prompted to fill out a simple form providing their name and the relevant year, along with monthly expense details in three categories: Household, Office, and Commuting Expenditure.

The system performs two essential calculations: monthly expenses and annual expenses. Users can download the generated report after making a mandatory payment, facilitated by the **Cash Free Java SDK**. The report is preferably available in PDF format, but an Excel option is also provided if time constraints arise.

<h2 align="center" style="color:#1E90FF;">Microservice Architecture</h2>


The application follows a robust and scalable Microservice architecture, consisting of the following three key microservices:

1. **Payment Microservice**: Responsible for handling all payment-related functionalities.
2. **Expense Microservice**: Manages expense calculations for each user's data.
3. **Authentication Microservice**: Handles JWT-based user authentication.

To streamline communication and enhance scalability, the app integrates an API Gateway and a Service Registry.

<h2 align="center" style="color:#1E90FF;">Instructions for Running the App</h2>


1. Clone this repository to your local machine.
2. Install the necessary dependencies and ensure you have Java SDK and Cash Free Java SDK set up.
3. Start the Microservices in the following order:
   - Authentication Microservice
   - Expense Microservice
   - Payment Microservice
   - API Gateway
   - Service Registry
4. Launch the app and navigate to the provided URL in your web browser.
5. Register or log in using your credentials via JWT Authentication.
6. Fill in the required form with your name, year, and monthly expense details.
7. The system will calculate and display your monthly and annual expenses.
8. To download the report, proceed with the payment using the Cash Free Java SDK.
9. After payment, download your report in PDF format.

<h2 align="center" style="color:#1E90FF;">Contributors</h2>


- [Avanish Mani Tripathi](https://github.com/avanishmani) - Developer and Maintainer

<h2 align="center" style="color:#1E90FF;">Contact</h2>


For any inquiries or support, please contact us at:
- Email: avanishmanitripathi@gmail.com
- Mobile: +91-9451269954
