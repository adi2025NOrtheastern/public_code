//#include<stdio.h>
//#include<conio.h>
//
//struct Item {
//    int id;
//    char* fname;
//    char* lname;
//    char* course;
//};
//
//struct Node
//{
//    struct Item* item;
//    struct Node* next;
//}*top = NULL;
//
//void push(struct Item *);
//void pop();
//void display();
//void pushAll();
//void popAll();
//
//void main()
//{
//    int choice, value;
//    //clrscr();
//    printf("\n:: Stack using Linked List ::\n");
//    //while (1) {
//    //    printf("\n****** MENU ******\n");
//    //    printf("1. Push\n2. Pop\n3. Display\n4. Exit\n");
//    //    printf("Enter your choice: ");
//    //    scanf_s("%d", &choice);
//    //    switch (choice) {
//    //    case 1: printf("Pushing all data: ");
//    //        //scanf_s("%d", &value);
//    //        //push(value);
//    //        pushAll();
//    //        break;
//    //    case 2: pop(); break;
//    //    case 3: display(); break;
//    //    case 4: exit(0);
//    //    default: printf("\nWrong selection!!! Please try again!!!\n");
//    printf("Pushing all elements: ");
//    pushAll();
//    printf("Displaying All: ");
//    display();
//    printf("Popping All: ");
//    popAll();
//       // }
//   // }
//}
//void push(struct Item *value)
//{
//    struct Node* newNode;
//    newNode = (struct Node*)malloc(sizeof(struct Node));
//    newNode->item = value;
//    if (top == NULL)
//        newNode->next = NULL;
//    else
//        newNode->next = top;
//    top = newNode;
//    printf("\nInsertion is Success!!!\n");
//}
//void pop()
//{
//    if (top == NULL)
//        printf("\nStack is Empty!!!\n");
//    else {
//        struct Node* temp = top;
//        printf("\nDeleted element: %d,", temp->item->id);
//        printf("%s,", temp->item->fname);
//        printf("%s,", temp->item->lname);
//        printf("%s", temp->item->course);
//        top = temp->next;
//        free(temp);
//    }
//}
//void display()
//{
//    if (top == NULL)
//        printf("\nStack is Empty!!!\n");
//    else {
//        struct Node* temp = top;
//        while (temp->next != NULL) {
//            printf("%d,", temp->item->id);
//            printf("%s,", temp->item->fname);
//            printf("%s,", temp->item->lname);
//            printf("%s--->\n", temp->item->course);
//            temp = temp->next;
//        }
//        //printf("%d--->NULL", temp->item);
//        printf("%d,", temp->item->id);
//        printf("%s,", temp->item->fname);
//        printf("%s,", temp->item->lname);
//        printf("%s--->NULL", temp->item->course);
//    }
//}
//
//void popAll() {
//
//    for (int i = 0;i < 10;i++)
//    {
//        pop();
//    }
//}
//
//void pushAll() {
//    struct Item* newNode;
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 1;
//    newNode->fname = "Jack";
//    newNode->lname = "Irwan";
//    newNode->course = "Software Engineering";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 2;
//    newNode->fname = "Billy";
//    newNode->lname = "Mckao";
//    newNode->course = "Requirement Engineering";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 3;
//    newNode->fname = "Nat";
//    newNode->lname = "Mcfaden";
//    newNode->course = "Multivariate Calculus";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 4;
//    newNode->fname = "Steven";
//    newNode->lname = "Shwimmer";
//    newNode->course = "Software Architecture Engineering";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 5;
//    newNode->fname = "Ruby";
//    newNode->lname = "jason";
//    newNode->course = "Relational DBMS";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 6;
//    newNode->fname = "Mark";
//    newNode->lname = "Dyne";
//    newNode->course = "PHP Developemnt";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 7;
//    newNode->fname = "Philip";
//    newNode->lname = "namdaf";
//    newNode->course = "Microsoft Dot Net Platform";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 8;
//    newNode->fname = "Erik";
//    newNode->lname = "Bawn";
//    newNode->course = " HTML And Scripting";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 9;
//    newNode->fname = "Ricky";
//    newNode->lname = "ben";
//    newNode->course = " Data communication";
//    push(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 10;
//    newNode->fname = "Van";
//    newNode->lname = "Miecky";
//    newNode->course = "Computer Networks";
//    push(newNode);
//}