# Most Common Words

Start development
```
make run-dev
```

```
curl -X POST http://localhost:8080/api/text -H 'Content-type:application/json' -d '{"text":"hello whats up hello. this is your song"}'
curl -X POST https://most-commonly-used-words.herokuapp.com/api/text -H 'Content-type:application/json' -d '{"text":"hello whats up hello. this is your song"}'
```