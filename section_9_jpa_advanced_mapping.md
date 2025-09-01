# JPA/Hibernate Advanced Mapping

## Summary

### Advanced Mapping
* 1 to 1
* 1 to many
* many to 1
* many to many

### Primary and Foreign Key
* foreign key:
    * link tables together
    * a field in one table that refers to primary key in another table

1. CASCADE
    * On Delete: Automatically deletes the corresponding rows in the child table when a row in the parent table is deleted.
    * On Update: Automatically updates the corresponding rows in the child table when a row in the parent table is updated.
2. SET NULL
    * On Delete: Sets the foreign key column in the child table to NULL when the referenced row in the parent table is deleted.
    * On Update: Sets the foreign key column in the child table to NULL when the referenced row in the parent table is updated.
3. SET DEFAULT
    * On Delete: Sets the foreign key column in the child table to its default value when the referenced row in the parent table is deleted.
    * On Update: Sets the foreign key column in the child table to its default value when the referenced row in the parent table is updated.
4. NO ACTION
    * On Delete: Prevents the deletion of a row in the parent table if there are corresponding rows in the child table. An error is raised.
    * On Update: Prevents the update of a row in the parent table if there are corresponding rows in the child table. An error is raised.
5. RESTRICT
    * Similar to NO ACTION, it prevents the deletion or update of a row in the parent table if there are corresponding rows in the child table. The difference is that the check is executed immediately.

### Cascade
* When you do something on 1 table, it'll operate on the foreign key table as well (eg. casacade delete)

### Fetch Types: Eager vs lazy loading
* Eager: fetch everything
* Lazy: retrieve on request

### Uni-directional vs bi-directional

### Entity Lifecycle
???

## @OneToOne uni-directional mapping

Example:
```
CREATE TABLE `instructor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `youtube_channel` varchar(128) DEFAULT NULL,
  `hobby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `instructor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `instructor_detail_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`instructor_detail_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`) REFERENCES `instructor_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```

```
@Entity
@Table(name="instructor")
public class instructor {
    ...
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="instructor_detail_id")
    private InstructionDetail instructionDetail;
    ...
}
```

## @OneToOne bi-directional mapping

* NO sql changes required
* In `InstructorDetail` class:
    1. Add new field to reference `Instructor`
    2. Add getter/setter method for `Instructor`
        ```
        @...
        public class InstructorDetail {
            ...
            private Instructor instructor;

            public Instructor getInstructor() {
                return this.instructor
            }

            public void setInstructor(Instructor instructor) {
                this.instructor = instructor
            }
        }
        ```
    3. Add `@OneToOne` Annotation
        ```
        @...
        public class InstructorDetail {
            @OneToOne(mappedBy="instructorDetail", casacade=CascadeType.ALL)
            private Instructor instructor;
            ...
        }
        ```
        * `mappedBy` tells Hibernate
            * Look at the instructorDetail property in the `Instructor` class
            * Use information from the `Instructor` class @JoinColumn

* To get instructor from instructorDetail: `instructorDetail.getInstructor()`