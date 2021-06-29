Feature: End to End Tests for ToolsQA's Book store API

Description: The purpose of these tests are to cover End to End happy flows for customer

 Book Store Swagger URL : http://bookstore.toolssqa.com/swagger/index.html

      Background: User blgenerates token fir Authorization
          Given  I am an authorozed user
          
      Scenario: Authorized user is able to add and Remove a book
          Given A list of books are avilable
          When I add a book to my reading list
          Then The book is added
          When I remove a book from my reading list
          Then The book is removed