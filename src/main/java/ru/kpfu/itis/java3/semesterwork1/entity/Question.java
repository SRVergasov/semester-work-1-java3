package ru.kpfu.itis.java3.semesterwork1.entity;

public class Question {
    private int id;
    private String title;
    private String description;
    private int user_id;

    public Question(int id, String title, String description, int user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (user_id != question.user_id) return false;
        if (!title.equals(question.title)) return false;
        return description.equals(question.description);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + user_id;
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
