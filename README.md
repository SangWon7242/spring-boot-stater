# Spring Boot Next.js Starter - 백엔드

이 프로젝트는 Spring Boot를 사용한 백엔드 시작 템플릿입니다. 빠른 개발 시작을 위해 기본적인 설정과 구조를 제공합니다.

## 시작하기

이 가이드는 프로젝트를 로컬 환경에서 설정하고 실행하는 방법을 안내합니다.

### 사전 준비 사항

*   **Java Development Kit (JDK) 17 이상**: Spring Boot 애플리케이션 실행을 위해 필요합니다.
*   **Gradle**: 프로젝트 빌드 도구입니다. (대부분의 IDE에 내장되어 있습니다.)
*   **IDE (통합 개발 환경)**: IntelliJ IDEA, Eclipse 등 Java 개발을 지원하는 IDE를 권장합니다.
*   **Git**: 프로젝트 소스 코드를 다운로드하기 위해 필요합니다.

### 프로젝트 다운로드

GitHub에서 이 프로젝트를 클론(Clone)하여 로컬 환경에 다운로드합니다.

```bash
git clone https://github.com/SangWon7242/spring-boot-stater
cd spring-boot-stater
```

### 프로젝트 실행

1.  **IDE에서 프로젝트 열기**: 선호하는 IDE(예: IntelliJ IDEA)를 열고, 다운로드한 `backend-starter` 디렉토리를 프로젝트로 임포트(Import)합니다. Gradle 프로젝트로 인식될 것입니다.
2.  **의존성 다운로드**: IDE가 자동으로 Gradle 의존성을 다운로드하도록 기다리거나, 수동으로 Gradle 빌드를 실행하여 의존성을 다운로드합니다.
3.  **애플리케이션 실행**:
    *   IDE에서 `BackendStarterApplication.java` 파일을 찾아 실행합니다.
    *   또는 터미널에서 다음 Gradle 명령어를 사용하여 실행할 수 있습니다:
        ```bash
        ./gradlew bootRun
        ```
4.  **확인**: 애플리케이션이 성공적으로 시작되면, 일반적으로 `http://localhost:8080`에서 백엔드 API에 접근할 수 있습니다. (포트 번호는 설정에 따라 다를 수 있습니다.)

## 나만의 프로젝트로 만들기

이 스타터 프로젝트를 기반으로 자신만의 애플리케이션을 개발하려면 다음 단계를 따르세요.

1.  **프로젝트 이름 변경**:
    *   `settings.gradle` 파일에서 `rootProject.name`을 원하는 프로젝트 이름으로 변경합니다.
    *   `build.gradle` 파일에서 `group` 및 `version` 정보를 업데이트합니다.
    *   IDE의 리팩토링 기능을 사용하여 메인 애플리케이션 클래스(`BackendStarterApplication.java`)의 이름과 패키지 구조를 변경하는 것을 고려할 수 있습니다.
2.  **새로운 Git 저장소 초기화**:
    *   기존 `.git` 디렉토리를 삭제합니다: `rm -rf .git` (Windows에서는 `rd /s /q .git`)
    *   새로운 Git 저장소를 초기화하고 원격 저장소를 연결합니다:
        ```bash
        git init
        git add .
        git commit -m "Initial commit from starter project"
        git branch -M main
        git remote add origin https://github.com/your-new-username/your-new-project.git
        git push -u origin main
        ```
    *   `your-new-username`과 `your-new-project`는 실제 GitHub 사용자 이름과 새로운 프로젝트 이름으로 대체해야 합니다.
3.  **코드 개발**: 이제 자신만의 비즈니스 로직, 엔티티, 서비스, 컨트롤러 등을 추가하여 애플리케이션을 개발할 수 있습니다.

즐거운 개발 되세요!