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
//}*front = NULL, * rear = NULL;
//
//void insert(struct Item *);
//void delete();
//void display();
//void deleteAll();
//void insertAll();
//
//void main()
//{
//    int choice, value;
//    //clrscr();
//    printf("\n:: Queue Implementation using Linked List ::\n");
//    //while (1) {
//    //    printf("\n****** MENU ******\n");
//    //    printf("1. Insert\n2. Delete\n3. Display\n4. Exit\n");
//    //    printf("Enter your choice: ");
//    //    scanf_s("%d", &choice);
//    //    switch (choice) {
//    //    case 1: printf("Enter the value to be insert: ");
//    //        //scanf_s("%d", &value);
//    //        insertAll();
//    //        break;
//    //    case 2:  break;
//    //    case 3: display(); break;
//    //    case 4: exit(0);
//    //    default: printf("\nWrong selection!!! Please try again!!!\n");
//    //    }
//    //}
//
//    printf("Inserting all elements: ");
//    insertAll();
//    printf("Displaying All: ");
//    display();
//    printf("Popping All: ");
//    
//    deleteAll();
//}
//void insert(struct Item* value)
//{
//    struct Node* newNode;
//    newNode = (struct Node*)malloc(sizeof(struct Node));
//    newNode->item = value;
//    newNode->next = NULL;
//    if (front == NULL)
//        front = rear = newNode;
//    else {
//        rear->next = newNode;
//        rear = newNode;
//    }
//    printf("\nInsertion is Success!!!\n");
//}
//void delete()
//{
//    if (front == NULL)
//        printf("\nQueue is Empty!!!\n");
//    else {
//        struct Node* temp = front;
//        front = front->next;
//       // printf("\nDeleted element: %d\n", temp->item);
//        printf("\nDeleted element: %d,", temp->item->id);
//        printf("%s,", temp->item->fname);
//        printf("%s,", temp->item->lname);
//        printf("%s", temp->item->course);
//        free(temp);
//    }
//}
//void display()
//{
//    if (front == NULL)
//        printf("\nQueue is Empty!!!\n");
//    else {
//        struct Node* temp = front;
//        while (temp->next != NULL) {
//            //printf("%d--->", temp->data);
//            printf("%d,", temp->item->id);
//            printf("%s,", temp->item->fname);
//            printf("%s,", temp->item->lname);
//            printf("%s--->\n", temp->item->course);
//            temp = temp->next;
//        }
//        //printf("%d--->NULL\n", temp->data);
//        printf("%d,", temp->item->id);
//        printf("%s,", temp->item->fname);
//        printf("%s,", temp->item->lname);
//        printf("%s--->NULL", temp->item->course);
//    }
//}
//
//void deleteAll() {
//
//    for (int i = 0;i < 10;i++)
//    {
//        delete();
//    }
//}
//
//void insertAll() {
//    struct Item* newNode;
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 1;
//    newNode->fname = "Jack";
//    newNode->lname = "Irwan";
//    newNode->course = "Software Engineering";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 2;
//    newNode->fname = "Billy";
//    newNode->lname = "Mckao";
//    newNode->course = "Requirement Engineering";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 3;
//    newNode->fname = "Nat";
//    newNode->lname = "Mcfaden";
//    newNode->course = "Multivariate Calculus";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 4;
//    newNode->fname = "Steven";
//    newNode->lname = "Shwimmer";
//    newNode->course = "Software Architecture Engineering";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 5;
//    newNode->fname = "Ruby";
//    newNode->lname = "jason";
//    newNode->course = "Relational DBMS";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 6;
//    newNode->fname = "Mark";
//    newNode->lname = "Dyne";
//    newNode->course = "PHP Developemnt";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 7;
//    newNode->fname = "Philip";
//    newNode->lname = "namdaf";
//    newNode->course = "Microsoft Dot Net Platform";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 8;
//    newNode->fname = "Erik";
//    newNode->lname = "Bawn";
//    newNode->course = " HTML And Scripting";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 9;
//    newNode->fname = "Ricky";
//    newNode->lname = "ben";
//    newNode->course = " Data communication";
//    insert(newNode);
//
//    newNode = (struct Item*)malloc(sizeof(struct Item));
//    newNode->id = 10;
//    newNode->fname = "Van";
//    newNode->lname = "Miecky";
//    newNode->course = "Computer Networks";
//    insert(newNode);
//}