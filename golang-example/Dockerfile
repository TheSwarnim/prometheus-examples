from golang:1.20.4-alpine3.18 as builder

# Set the Current Working Directory inside the container
WORKDIR /app

# Copy go mod and sum files
COPY go.mod go.sum ./

RUN go mod download

COPY . .

# Build the Go app
RUN go build -o main .

# expose port 9000
EXPOSE 9000

# Command to run the executable
CMD ["./main"]
