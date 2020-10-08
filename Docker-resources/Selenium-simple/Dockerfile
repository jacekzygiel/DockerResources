FROM python

COPY ./githubTest.py /app/githubTest.py
COPY ./requirements.txt /app/requirements.txt

WORKDIR /app

RUN pip install -r requirements.txt
ENTRYPOINT [ "python" ]
CMD [ "githubTest.py" ]