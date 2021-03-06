run-dev:
	docker compose -f docker-compose.dev.yml up --build

tests:
	docker build -t mostcommonwords-api --progress=plain --target test .

run-prod:
	docker compose -f docker-compose.yml up --build
