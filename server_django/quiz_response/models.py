from django.db import models
from quiz.models import Quiz
from django.contrib.auth.models import User

# Creates a model for the quiz response item.  It essentially
# creates the schema in the database for the quiz response item,
# including all fields and types.  This represents each response to a survey,
# which encompasses the respondent's FK and update info.  All individual question
# response data is located in question_response
class QuizResponse(models.Model):
    # the quiz this response corresponds to
    quiz = models.ForeignKey(Quiz)
    user = models.ForeignKey(User)
    createTime = models.DateTimeField(auto_now_add=True)
    updateTime = models.DateTimeField(auto_now=True)
    